"use client";

import { useTranslation } from "react-i18next";
import Button from "@components/atoms/Button/Button";

export default function LoginPage(): React.JSX.Element {
  const { t } = useTranslation();

  const handleLogin = (): void => {
    // TODO: Trigger MSAL login redirect via Azure Entra ID
  };

  return (
    <div className="LoginPage-Container">
      <div className="LoginPage-Card">
        <h1 className="LoginPage-Title">{t("common.appName")}</h1>
        <p className="LoginPage-Subtitle">{t("dua.title")}</p>
        <Button label={t("auth.login")} onClick={handleLogin} variant="primary" />
      </div>
    </div>
  );
}
