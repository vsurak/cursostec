import { redirect } from "next/navigation";
import { ROUTES } from "@utils/constants";

export default function HomePage(): never {
  redirect(ROUTES.DASHBOARD);
}
