/*
 * Copyright (c) 2012-2015, Luigi R. Viggiano
 * All rights reserved.
 *
 * This software is distributable under the BSD license.
 * See the terms of the BSD license in the documentation provided with this software.
 */

package org.aeonbits.owner.reload;

import static java.lang.Thread.sleep;

/**
 * @author luigi
 */
public class AsyncReloadSupport {
    private Object reloadLock = new Object();

    void waitForReload(final long timeout) throws InterruptedException {
        sleep(300);
        synchronized (reloadLock) {
            reloadLock.wait(timeout);
        }
    }

    void notifyReload() throws InterruptedException {
        synchronized (reloadLock) {
            reloadLock.notifyAll();
        }
        sleep(300);
    }

}
