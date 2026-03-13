"use client";

import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";
import DuaForm from "@components/organisms/DuaForm/DuaForm";

export default function DuaListPage(): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="DuaListPage-Container">
        <h1 className="DuaListPage-Title">{t("dua.title")}</h1>
        <DuaForm />
        {/* TODO: DUA list table with status, confidence, and actions */}
      </div>
    </MainLayout>
  );
}
