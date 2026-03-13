import type { Metadata } from "next";
import "./globals.css";
import StoreProvider from "@state/StoreProvider";

export const metadata: Metadata = {
  title: "DUA Streamliner",
  description: "Automated customs declaration document processing system",
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}): React.JSX.Element {
  return (
    <html lang="es">
      <body>
        <StoreProvider>{children}</StoreProvider>
      </body>
    </html>
  );
}
