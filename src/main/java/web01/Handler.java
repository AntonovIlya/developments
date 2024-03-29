package web01;

import java.io.BufferedOutputStream;

@FunctionalInterface
public interface Handler {

    void handle(Request request, BufferedOutputStream out);
}
