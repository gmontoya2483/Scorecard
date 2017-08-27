package com.montoya.gabi.scorecard.widget;

import android.content.Intent;
import android.widget.RemoteViewsService;

/**
 * Created by Gabriel on 27/08/2017.
 */

public class DetailWidgetRemoteViewsService extends RemoteViewsService {
    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new DetailedWidgetRemoteViewsFactory(getBaseContext(),intent);
    }
}
