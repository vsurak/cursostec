"use client";

import { useTranslation } from "react-i18next";
import { SUPPORTED_FILE_EXTENSIONS } from "@utils/constants";

interface FileUploaderProps {
  onFilesSelected: (files: FileList) => void;
  isUploading: boolean;
  disabled?: boolean;
}

export default function FileUploader({
  onFilesSelected,
  isUploading,
  disabled = false,
}: FileUploaderProps): React.JSX.Element {
  const { t } = useTranslation();

  const handleDrop = (e: React.DragEvent<HTMLDivElement>): void => {
    e.preventDefault();
    if (e.dataTransfer.files.length > 0) {
      onFilesSelected(e.dataTransfer.files);
    }
  };

  const handleDragOver = (e: React.DragEvent<HTMLDivElement>): void => {
    e.preventDefault();
  };

  const handleFileInput = (e: React.ChangeEvent<HTMLInputElement>): void => {
    if (e.target.files && e.target.files.length > 0) {
      onFilesSelected(e.target.files);
    }
  };

  return (
    <div
      className="FileUploader-DropZone"
      onDrop={handleDrop}
      onDragOver={handleDragOver}
    >
      <input
        type="file"
        multiple
        accept={SUPPORTED_FILE_EXTENSIONS.join(",")}
        onChange={handleFileInput}
        disabled={disabled || isUploading}
        className="FileUploader-Input"
        id="file-upload"
      />
      <label htmlFor="file-upload" className="FileUploader-Label">
        {isUploading ? t("files.uploading") : t("files.dragDrop")}
      </label>
      <p className="FileUploader-Info">{t("files.supported")}</p>
      <p className="FileUploader-Info">{t("files.maxSize")}</p>
    </div>
  );
}
