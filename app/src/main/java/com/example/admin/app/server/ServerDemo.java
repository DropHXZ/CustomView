package com.example.admin.app.server;

import android.Manifest;
import android.bluetooth.BluetoothGattService;

import java.security.Provider;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by admin on 2017/11/22.
 */

public class ServerDemo extends BluetoothGattService {


    /**
     * Create a new BluetoothGattService.
     * <p>Requires {@link Manifest.permission#BLUETOOTH} permission.
     *
     * @param uuid        The UUID for this service
     * @param serviceType The type of this service,
     *                    {@link BluetoothGattService#SERVICE_TYPE_PRIMARY} or
     *                    {@link BluetoothGattService#SERVICE_TYPE_SECONDARY}
     */
    public ServerDemo(UUID uuid, int serviceType) {
        super(uuid, serviceType);
    }
}
