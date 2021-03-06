package org.tarantool;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface TarantoolClient {
    TarantoolClientOps<Integer, List<?>, Object, List<?>> syncOps();

    TarantoolClientOps<Integer, List<?>, Object, ? extends Future<List<?>>> asyncOps();

    TarantoolClientOps<Integer, List<?>, Object, CompletionStage<List<?>>> composableAsyncOps();

    TarantoolClientOps<Integer, List<?>, Object, Long> fireAndForgetOps();

    void close();

    boolean isAlive();

    void waitAlive() throws InterruptedException;

    boolean waitAlive(long timeout, TimeUnit unit) throws InterruptedException;

}
