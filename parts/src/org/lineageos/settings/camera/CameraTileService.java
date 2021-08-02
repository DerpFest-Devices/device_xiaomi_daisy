package org.lineageos.settings.camera;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import org.lineageos.settings.R;

public class CameraTileService extends TileService {

    private CameraUtils mCameraUtils;

    public static final String CAMERA_SYSTEM_PROPERTY = "persist.camera.profile";

    @Override
    public void onStartListening() {
        int currentState = mCameraUtils.getintProp(CAMERA_SYSTEM_PROPERTY, 0);
        Tile tile = getQsTile();

        if (currentState == 0) {
            tile.setState(Tile.STATE_INACTIVE);
        } else {
            tile.setState(Tile.STATE_ACTIVE);
        }

        tile.setLabel(getResources().getStringArray(R.array.camera_entries)[currentState]);
        tile.updateTile();
        super.onStartListening();
    }

    @Override
    public void onClick() {
        int currentState = mCameraUtils.getintProp(CAMERA_SYSTEM_PROPERTY, 0);
        Tile tile = getQsTile();

        int nextState;
        if (currentState == 1) {
            tile.setState(Tile.STATE_INACTIVE);
            nextState = 0;
        } else {
            tile.setState(Tile.STATE_ACTIVE);
            nextState = currentState + 1;
        }

        mCameraUtils.setintProp(CAMERA_SYSTEM_PROPERTY, nextState);
        tile.setLabel(getResources().getStringArray(R.array.camera_entries)[nextState]);

        tile.updateTile();
        super.onClick();
    }
}
