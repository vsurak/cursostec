"use client";

import Navbar from "@components/organisms/Navbar/Navbar";

interface MainLayoutProps {
  children: React.ReactNode;
}

export default function MainLayout({ children }: MainLayoutProps): React.JSX.Element {
  return (
    <div className="MainLayout-Root">
      <Navbar />
      <main className="MainLayout-Content">{children}</main>
    </div>
  );
}
