package ru.avkalabin.front;

import ru.avkalabin.session.UserSession;

public class Front implements FtBase {

    public final FtBase[] frontParts;

    public Front(FtBase... frontParts) {
        this.frontParts = frontParts;
    }

    @Override
    public void start(UserSession userSession) throws Exception {
        for (FtBase front : frontParts) {
            front.start(userSession);
        }
    }
}
