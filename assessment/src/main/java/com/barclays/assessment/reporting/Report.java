package com.barclays.assessment.reporting;

import java.io.ByteArrayInputStream;

public interface Report {

    public ByteArrayInputStream generateReport();
}
