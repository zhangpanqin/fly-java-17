package com.fly.machine.code;

import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

public class WindowCode {
    public static void main(String[] args) {
        SystemInfo systemInfo = new SystemInfo();
        final HardwareAbstractionLayer hardware = systemInfo.getHardware();
        final ComputerSystem computerSystem = hardware.getComputerSystem();
        //
        System.out.println(computerSystem.getHardwareUUID());
        // 获取主板序列号
        System.out.println(computerSystem.getBaseboard().getSerialNumber());
    }
    public static String getComputerIdentifier() {
        SystemInfo systemInfo = new SystemInfo();
        OperatingSystem operatingSystem = systemInfo.getOperatingSystem();
        HardwareAbstractionLayer hardwareAbstractionLayer = systemInfo.getHardware();
        CentralProcessor centralProcessor = hardwareAbstractionLayer.getProcessor();
        ComputerSystem computerSystem = hardwareAbstractionLayer.getComputerSystem();

        String vendor = operatingSystem.getManufacturer();
        String processorSerialNumber = computerSystem.getSerialNumber();
        String uuid = computerSystem.getHardwareUUID();
        String processorIdentifier = centralProcessor.getProcessorIdentifier().getIdentifier();
        int processors = centralProcessor.getLogicalProcessorCount();

        String delimiter = "-";

        return String.format("%08x", vendor.hashCode()) + delimiter
                + String.format("%08x", processorSerialNumber.hashCode()) + delimiter
                + String.format("%08x", uuid.hashCode()) + delimiter
                + String.format("%08x", processorIdentifier.hashCode()) + delimiter + processors;
    }
}
