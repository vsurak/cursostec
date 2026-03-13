"use client";

import { useTranslation } from "react-i18next";

type ButtonVariant = "primary" | "secondary" | "danger" | "ghost";

interface ButtonProps {
  label: string;
  onClick: () => void;
  variant?: ButtonVariant;
  disabled?: boolean;
  isLoading?: boolean;
  type?: "button" | "submit" | "reset";
}

export default function Button({
  label,
  onClick,
  variant = "primary",
  disabled = false,
  isLoading = false,
  type = "button",
}: ButtonProps): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <button
      className={`Button-Root Button-${variant}`}
      onClick={onClick}
      disabled={disabled || isLoading}
      type={type}
    >
      {isLoading ? t("common.loading") : label}
    </button>
  );
}
