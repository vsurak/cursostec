"use client";

import { useEffect, useCallback } from "react";
import { NotificationService, NotificationCallback } from "@notificationService/NotificationService";

const notificationService = NotificationService.getInstance();

export function useNotification(event: string, callback: NotificationCallback) {
  useEffect(() => {
    notificationService.subscribe(event, callback);
    return () => {
      notificationService.unsubscribe(event, callback);
    };
  }, [event, callback]);

  const notify = useCallback(
    (data: unknown) => {
      notificationService.notify(event, data);
    },
    [event],
  );

  return { notify };
}
