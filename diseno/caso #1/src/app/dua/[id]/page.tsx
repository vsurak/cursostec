"use client";

import { useParams } from "next/navigation";
import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";

export default function DuaDetailPage(): React.JSX.Element {
  const params = useParams<{ id: string }>();
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="DuaDetailPage-Container">
        <h1 className="DuaDetailPage-Title">
          {t("dua.title")} - {params.id}
        </h1>
        {/* TODO: DUA field review with confidence indicators, edit capabilities, and download */}
      </div>
    </MainLayout>
  );
}
