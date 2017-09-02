package com.montoya.gabi.scorecard.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Gabriel on 02/09/2017.
 */

public class ScorecardWidgetService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new ScorecardWidgetDataProvider(this,intent);
    }
}
