package org.smartlearning.domain.content.time;

import org.springframework.stereotype.Service;

/**
 * @Author Karol Meksuła
 * 11-03-2018
 **/

@Service
public class NanoParserImpl implements NanoParser {
    private final long ONE_SECOND = 1000000000;

    @Override
    public long parseNanoToSeconds(long nano) {
        return nano / ONE_SECOND;
    }

}
