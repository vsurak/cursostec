"use client";

import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";

export default function ReportsPage(): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="ReportsPage-Container">
        <h1 className="ReportsPage-Title">{t("nav.reports")}</h1>
        {/* TODO: Operational and performance reports (Manager role only - VIEW_REPORTS permission) */}
      </div>
    </MainLayout>
  );
}
