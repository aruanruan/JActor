package org.agilewiki.jactor.components.nblock;

import junit.framework.TestCase;
import org.agilewiki.jactor.JAFuture;
import org.agilewiki.jactor.JAMailboxFactory;
import org.agilewiki.jactor.MailboxFactory;
import org.agilewiki.jactor.bind.Request;
import org.agilewiki.jactor.components.Include;
import org.agilewiki.jactor.components.JCActor;
import org.agilewiki.jactor.components.nbLock.NBLock;

public class NBLockTest extends TestCase {
    public void test() {
        MailboxFactory mailboxFactory = JAMailboxFactory.newMailboxFactory(1);
        try {
            JAFuture future = new JAFuture();
            JCActor driver = new JCActor(mailboxFactory.createMailbox());
            (new Include(Driver.class)).call(driver);
            (new Include(NBLock.class)).call(driver);
            (new DoIt()).send(future, driver);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mailboxFactory.close();
        }
    }
}

class DoIt extends Request<Object> {
}
