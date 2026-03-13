"use client";

import Link from "next/link";
import { useTranslation } from "react-i18next";
import { useAppSelector } from "@state/hooks";
import { ROUTES } from "@utils/constants";
import { hasPermission } from "@auth/permissions";
import { PermissionCodes } from "@models/Role";

export default function Navbar(): React.JSX.Element {
  const { t } = useTranslation();
  const { user, role } = useAppSelector((state) => state.auth);

  return (
    <nav className="Navbar-Root">
      <div className="Navbar-Brand">
        <Link href={ROUTES.DASHBOARD} className="Navbar-Logo">
          {t("common.appName")}
        </Link>
      </div>
      <ul className="Navbar-Links">
        <li>
          <Link href={ROUTES.DASHBOARD}>{t("nav.dashboard")}</Link>
        </li>
        <li>
          <Link href={ROUTES.DUA_LIST}>{t("nav.dua")}</Link>
        </li>
        {role && hasPermission(role, PermissionCodes.MANAGE_USERS) && (
          <li>
            <Link href={ROUTES.USERS}>{t("nav.users")}</Link>
          </li>
        )}
        {role && hasPermission(role, PermissionCodes.VIEW_REPORTS) && (
          <li>
            <Link href={ROUTES.REPORTS}>{t("nav.reports")}</Link>
          </li>
        )}
        {role && hasPermission(role, PermissionCodes.EDIT_TEMPLATES) && (
          <li>
            <Link href={ROUTES.TEMPLATES}>{t("nav.templates")}</Link>
          </li>
        )}
      </ul>
      <div className="Navbar-User">
        {user && <span>{t("auth.welcome", { name: user.displayName })}</span>}
      </div>
    </nav>
  );
}
