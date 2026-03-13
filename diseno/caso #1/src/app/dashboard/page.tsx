"use client";

import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";

export default function DashboardPage(): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="DashboardPage-Container">
        <h1 className="DashboardPage-Title">{t("nav.dashboard")}</h1>
        {/* TODO: Dashboard widgets - recent DUAs, processing status, quick actions */}
      </div>
    </MainLayout>
  );
}
