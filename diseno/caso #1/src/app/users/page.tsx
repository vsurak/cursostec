"use client";

import { useTranslation } from "react-i18next";
import MainLayout from "@components/templates/MainLayout/MainLayout";

export default function UsersPage(): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <MainLayout>
      <div className="UsersPage-Container">
        <h1 className="UsersPage-Title">{t("users.title")}</h1>
        {/* TODO: User management CRUD table (Manager role only - MANAGE_USERS permission) */}
      </div>
    </MainLayout>
  );
}
