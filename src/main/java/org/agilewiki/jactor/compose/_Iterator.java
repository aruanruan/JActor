package org.agilewiki.jactor.compose;

import org.agilewiki.jactor.JAIterator;
import org.agilewiki.jactor.ResponseProcessor;

public class _Iterator extends _Operation {
    JAIterator iterator;
    private String resultName;

    public _Iterator(JAIterator iterator, String resultName) {
        this.iterator = iterator;
        this.resultName = resultName;
    }

    @Override
    public void call(final _Compose compose, final ResponseProcessor rp) throws Exception {
        final State oldState = compose.getState();
        iterator.iterate(new ResponseProcessor() {
            @Override
            public void process(Object response) throws Exception {
                if (resultName != null) oldState.results.put(resultName, response);
                compose.setState(oldState);
                rp.process(null);
            }
        });
    }
}