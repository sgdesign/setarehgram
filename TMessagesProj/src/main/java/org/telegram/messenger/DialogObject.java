/*
 * This is the source code of ستاره گرام for Android v. 3.x.x.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 *
 * Copyright Nikolai Kudashov, 2013-2017.
 */

package org.zanbilapp.messenger;

import org.ستاره گرام.tgnet.TLRPC;

public class DialogObject {

    public static boolean isChannel(TLRPC.TL_dialog dialog) {
        return dialog != null && (dialog.flags & 1) != 0;
    }
}
