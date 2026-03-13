export type NotificationCallback = (data: unknown) => void;

export class NotificationService {
  private static instance: NotificationService | null = null;
  private subscribers: Map<string, Set<NotificationCallback>> = new Map();

  private constructor() {}

  static getInstance(): NotificationService {
    if (!NotificationService.instance) {
      NotificationService.instance = new NotificationService();
    }
    return NotificationService.instance;
  }

  subscribe(event: string, callback: NotificationCallback): void {
    if (!this.subscribers.has(event)) {
      this.subscribers.set(event, new Set());
    }
    this.subscribers.get(event)!.add(callback);
  }

  unsubscribe(event: string, callback: NotificationCallback): void {
    const eventSubscribers = this.subscribers.get(event);
    if (eventSubscribers) {
      eventSubscribers.delete(callback);
      if (eventSubscribers.size === 0) {
        this.subscribers.delete(event);
      }
    }
  }

  notify(event: string, data: unknown): void {
    const eventSubscribers = this.subscribers.get(event);
    if (eventSubscribers) {
      eventSubscribers.forEach((callback) => {
        try {
          callback(data);
        } catch (error) {
          console.error(`Notification callback error for event "${event}":`, error);
        }
      });
    }
  }

  handleCallbackPayload(payload: { event: string; data: unknown }): void {
    this.notify(payload.event, payload.data);
  }

  getSubscriberCount(event: string): number {
    return this.subscribers.get(event)?.size || 0;
  }

  clearAll(): void {
    this.subscribers.clear();
  }
}
