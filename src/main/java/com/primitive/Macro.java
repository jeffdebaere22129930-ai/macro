package com.primitive;

import java.util.Locale;
import java.util.UUID;

/** One recorded macro: a snapshot of the player's inputs for every client tick (20 per second). */
public class Macro {
    public String id = UUID.randomUUID().toString();
    public String name = "Macro";
    public long created = System.currentTimeMillis();

    public int[] keys = new int[0];      // bitmask of pressed keys, one entry per tick
    public float[] yaw = new float[0];   // look direction per tick
    public float[] pitch = new float[0];
    public byte[] slot = new byte[0];    // selected hotbar slot per tick

    public int length() {
        return keys.length;
    }

    public boolean valid() {
        return id != null && name != null && keys != null && yaw != null && pitch != null && slot != null
                && keys.length == yaw.length && yaw.length == pitch.length && pitch.length == slot.length;
    }

    public String duration() {
        return String.format(Locale.ROOT, "%.1fs", length() / 20f);
    }
}
