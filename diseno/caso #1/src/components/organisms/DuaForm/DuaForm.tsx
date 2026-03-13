"use client";

import { useTranslation } from "react-i18next";
import Button from "@components/atoms/Button/Button";
import FileUploader from "@components/molecules/FileUploader/FileUploader";
import { useDua } from "@hooks/useDua";
import { useFileUpload } from "@hooks/useFileUpload";

export default function DuaForm(): React.JSX.Element {
  const { t } = useTranslation();
  const { generateDua, isProcessing } = useDua();
  const { uploadFiles, isUploading } = useFileUpload();

  const handleFilesSelected = (files: FileList): void => {
    uploadFiles(files);
  };

  const handleGenerate = (): void => {
    generateDua();
  };

  return (
    <div className="DuaForm-Container">
      <h2 className="DuaForm-Title">{t("dua.generate")}</h2>
      <FileUploader onFilesSelected={handleFilesSelected} isUploading={isUploading} />
      <div className="DuaForm-Actions">
        <Button
          label={isProcessing ? t("dua.processing") : t("dua.generate")}
          onClick={handleGenerate}
          variant="primary"
          disabled={isProcessing || isUploading}
          isLoading={isProcessing}
        />
      </div>
    </div>
  );
}
