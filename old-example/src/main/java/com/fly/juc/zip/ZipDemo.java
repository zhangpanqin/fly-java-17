package com.fly.juc.zip;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipDemo {
    public static void main(String[] args) throws IOException {
        final String property = System.getProperty("user.dir");
        /**
         * dir/
         * dir/api.json
         * api.json
         */
        String zipFilePath = property + File.separator + "source" + File.separator + "test.zip";
        try (final ZipFile zipFile = new ZipFile(zipFilePath)) {
//            final ZipEntry dirAipJson = zipFile.getEntry("dir/api.json");
//            try (final InputStream inputStream = zipFile.getInputStream(dirAipJson);){
//                System.out.println(IoUtil.read(inputStream, StandardCharsets.UTF_8));
//            }catch (Exception e){
//
//            }
//            final ZipEntry dir = zipFile.getEntry("dir");

            try (final ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipFilePath));) {
                final ZipEntry zipEntry = new ZipEntry("create");
                final ZipEntry dir = new ZipEntry("create1/api.json");
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.putNextEntry(dir);
            } catch (Exception e) {

            }
        } catch (Exception e) {

        }
    }
}
