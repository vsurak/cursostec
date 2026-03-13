"use client";

import { useTranslation } from "react-i18next";
import { ConfidenceLevel } from "@models/Dua";

interface ConfidenceIndicatorProps {
  level: ConfidenceLevel;
}

export default function ConfidenceIndicator({
  level,
}: ConfidenceIndicatorProps): React.JSX.Element {
  const { t } = useTranslation();

  return (
    <span className={`ConfidenceIndicator-Root ConfidenceIndicator-${level}`}>
      {t(`dua.confidence.${level}`)}
    </span>
  );
}
