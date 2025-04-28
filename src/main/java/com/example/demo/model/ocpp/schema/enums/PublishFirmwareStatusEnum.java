package com.example.demo.model.ocpp.schema.enums;

public enum PublishFirmwareStatusEnum {
    IDLE,
    DOWNLOADSCHEDULED,
    DOWNLOADING,
    DOWNLOADED,
    PUBLISHED,
    DOWNLOADFAILED,
    DOWNLOADPAUSED,
    INVALIDCHECKSUM,
    CHECKSUMVERIFIED,
    PUBLISHFAILED,
}
