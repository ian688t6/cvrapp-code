package com.gc.cvrapp.cvr.commands;

import com.gc.cvrapp.cvr.Cvr;
import com.gc.cvrapp.cvr.Cvr.MediaListener;
import com.gc.cvrapp.cvr.CvrConstants;

import java.nio.ByteBuffer;

public class PlaybackVideoStopCommand extends Command {
    private MediaListener mListener;

    public PlaybackVideoStopCommand(Cvr cvr, MediaListener listener) {
        super(cvr);
        mListener = listener;
    }

    @Override
    public void exec(Cvr.CommandIO io) {
        io.handleCommand(this, null, 0);
    }

    @Override
    public void resp(Cvr.ResponseIO io, ByteBuffer resp, int payloadlen) {
        io.handleResponse(this, resp, payloadlen);
    }

    @Override
    public short code() {
        return CvrConstants.CommandCode.PlaybackVideoStop;
    }

    @Override
    public void encodeCommand(ByteBuffer b) {
        encodeCommand(b, CvrConstants.CommandCode.PlaybackVideoStop);
    }

    @Override
    protected void decodeData(short code, int arg1) {
        super.decodeData(code, arg1);
        mListener.onPlaybackStop();
    }
}
