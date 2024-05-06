package models;

public class FileObject implements Comparable<FileObject> {

    private int index;
    private String originalFileName;
    private String modifiedFilename;
    private String originalFolderName;
    private String modifiedFolderName;
    private String status;

    private String fileExt;

    public FileObject(int index, String originalFileName, String modifiedFilename, String originalFolderName, String modifiedFolderName, String status) {
        this.index = index;
        this.originalFileName = originalFileName;
        this.modifiedFilename = modifiedFilename;
        this.originalFolderName = originalFolderName;
        this.modifiedFolderName = modifiedFolderName;
        this.status = status;

        this.fileExt = this.originalFileName.substring(originalFileName.lastIndexOf("."));
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getModifiedFilename() {
        return modifiedFilename;
    }

    public void setModifiedFilename(String modifiedFilename) {
        this.modifiedFilename = modifiedFilename;
    }

    public String getOriginalFolderName() {
        return originalFolderName;
    }

    public void setOriginalFolderName(String originalFolderName) {
        this.originalFolderName = originalFolderName;
    }

    public String getModifiedFolderName() {
        return modifiedFolderName;
    }

    public void setModifiedFolderName(String modifiedFolderName) {
        this.modifiedFolderName = modifiedFolderName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(FileObject o) {
        return this.originalFileName.compareTo(o.originalFileName);
    }
}
