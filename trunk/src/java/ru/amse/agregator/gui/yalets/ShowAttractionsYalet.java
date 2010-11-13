package ru.amse.agregator.gui.yalets;

import net.sf.xfresh.core.InternalRequest;
import net.sf.xfresh.core.InternalResponse;

public class ShowAttractionsYalet extends AbstractAgregatorYalet {

    @Override
	public void process(InternalRequest req, InternalResponse res) {
        String tmp = req.getParameter(String.valueOf("findTextBox"));
        if (tmp != null && !"".equals(tmp)) {
            res.add(manager.getSomeAttraction(tmp));
        }

    }
}