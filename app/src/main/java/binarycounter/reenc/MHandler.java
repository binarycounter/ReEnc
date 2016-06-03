package binarycounter.reenc;

import android.content.Context;

import org.videolan.libvlc.LibVLC;
import org.videolan.libvlc.LibVlcException;


public class MHandler {

    LibVLC vlc1 = null;
    LibVLC vlc2 = null;
    int vlc1state = 0; //VLC States. 0=Idle, 1=PLPreBuffer, 2=PLPlay, 3=SinglePlay
    int vlc2state = 0;
    int nextvlc = 1;
    LibVLC vlca = null;

    public void init(Context pC)
    {
        vlc1 = new LibVLC();
        vlc2 = new LibVLC();
        try {
            vlc1.init(pC);
            vlc2.init(pC);
            vlca=vlc1;
        } catch (LibVlcException e) {
            e.printStackTrace();
        }
    }

    public void sLoadPlay(String media) {
        vlc1state=3;
        vlc2state=0;
        vlca.stop();
        vlca = vlc1;
        vlca.playMRL(media);
    }
    public void play() {vlca.play();}
    public void pause(){vlca.pause();}
    public void next() {}
    public void prev() {}
    public long getcTime() {return vlca.getTime();}
    public long getTime() {return vlca.getLength();}
    public boolean isPlaying() {return vlca.isPlaying();}
    public void preload(){}
    public void prebuffer(){}


    public void PLUnload(){}



}
