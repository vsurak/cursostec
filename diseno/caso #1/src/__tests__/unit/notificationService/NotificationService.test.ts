import { describe, it, expect, beforeEach, jest } from "@jest/globals";
import { NotificationService } from "@notificationService/NotificationService";

describe("NotificationService", () => {
  let service: NotificationService;

  beforeEach(() => {
    service = NotificationService.getInstance();
    service.clearAll();
  });

  it("should notify subscribers when event is triggered", () => {
    const callback = jest.fn();
    service.subscribe("test:event", callback);
    service.notify("test:event", { status: "completed" });

    expect(callback).toHaveBeenCalledWith({ status: "completed" });
  });

  it("should not notify after unsubscribe", () => {
    const callback = jest.fn();
    service.subscribe("test:event", callback);
    service.unsubscribe("test:event", callback);
    service.notify("test:event", { status: "completed" });

    expect(callback).not.toHaveBeenCalled();
  });

  it("should track subscriber count correctly", () => {
    const cb1 = jest.fn();
    const cb2 = jest.fn();
    service.subscribe("test:event", cb1);
    service.subscribe("test:event", cb2);

    expect(service.getSubscriberCount("test:event")).toBe(2);

    service.unsubscribe("test:event", cb1);
    expect(service.getSubscriberCount("test:event")).toBe(1);
  });
});
