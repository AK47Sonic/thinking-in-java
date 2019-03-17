package com.sonic.effectivejava.serializable;

import java.io.*;

/**
 * SessionDTO
 *
 * @author Sonic
 * @since 2019/3/17
 */
class SessionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int data; // Stores session data

    // Session activation time (creation, deserialization)
    private long activationTime;

    public SessionDTO(int data) {
        this.data = data;
        this.activationTime = System.currentTimeMillis();
    }

    public int getData() {
        return data;
    }

    public long getActivationTime() {
        return activationTime;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        System.out.println("Call writeObject");
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        System.out.println("Call readObject");
    }

    private Object readResolve() throws ObjectStreamException{
        System.out.println("Call readResolve");
        return new SessionDTO(5);
    }
}