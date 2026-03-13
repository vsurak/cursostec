"use client";

import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";

export default function TemplatesPage(): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="TemplatesPage-Container">
        <h1 className="TemplatesPage-Title">{t("nav.templates")}</h1>
        {/* TODO: DUA template management (Manager role only - EDIT_TEMPLATES permission) */}
      </div>
    </MainLayout>
  );
}
