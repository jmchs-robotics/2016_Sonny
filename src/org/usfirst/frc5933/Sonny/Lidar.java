package org.usfirst.frc5933.Sonny;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.can.CANJNI;

public class Lidar {
    private enum CommandState {
        READY, REQUEST_DISTANCE, WAIT_FOR_DISTANCE, DONE
    }

    /* Check the datasheets for your device for the arbitration IDs of the
    messages you want to send.  By convention, this is a bitstring
    containing the model number, manufacturer number, and api number. */
    private static final int REQUEST_RANGE_ARB_ID = 0x1;
    private static final int RESPOND_RANGE_ARB_ID = 0x2;

    /*  Device ID, from 0 to 63. */
    private static final int LIDAR_ID = 60; // FIXME: I think we change this ID

    private IntBuffer messageId = ByteBuffer.allocateDirect(4).asIntBuffer();
    private ByteBuffer data = ByteBuffer.allocateDirect(8);
    private ByteBuffer timestamp = ByteBuffer.allocate(4);
    private int range = 0;
    private CommandState state;

    public Lidar() {
        reset();
    }

    private void reset() {
        state = CommandState.READY;
        range = 0;
        // FIXME: do we have to increment the message id for each new message ?
    }
    
    private static int makeUnsignedByte(byte b) {
        return (int) b & 0xFF;
    }

    private void requestRange() {
        /* Again, see the datasheet for the device you're using.  It should
        specify what data to put here. */
        data.clear();
        data.putInt(1);

        /* Alternatively, instead of CAN_SEND_PERIOD_NO_REPEAT, you can specify
            a period in milliseconds to automatically send the message over
            and over again. */
        CANJNI.FRCNetworkCommunicationCANSessionMuxSendMessage(
                REQUEST_RANGE_ARB_ID | LIDAR_ID,
                data,
                CANJNI.CAN_SEND_PERIOD_NO_REPEAT
        );
        // FIXME I suppose we need to shift the ID some value.
    }

    public boolean hasValidRange() {
        if (state == CommandState.READY) {
            requestRange();
            state = CommandState.WAIT_FOR_DISTANCE;
        } else if (state == CommandState.WAIT_FOR_DISTANCE) {
            /* To receive a message, put the message ID you're looking for in this
            buffer.  CANJNI...ReceiveMessage  will not block waiting for it,
            but just return null if it hasn't been received yet. */
            messageId.clear();
            messageId.put(0, RESPOND_RANGE_ARB_ID | LIDAR_ID);

            ByteBuffer data = CANJNI.FRCNetworkCommunicationCANSessionMuxReceiveMessage(
                    messageId,
                    CANJNI.CAN_MSGID_FULL_M,
                    timestamp
            );

            if (data != null) {
                // FIXME remove debug
                System.out.println("Received a message: " + Arrays.toString(data.array()));
                range = (makeUnsignedByte(data.array()[0])<<8) + makeUnsignedByte(data.array()[1]);
                System.out.println("Range is: " + range);
                state = CommandState.DONE;
            }
        }
        return state == CommandState.DONE;
    }

    public int getRange() {
        int tmp = range;
        reset();
        return tmp;
    }
}
