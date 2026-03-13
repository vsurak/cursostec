"use client";

interface InputProps {
  id: string;
  name: string;
  value: string;
  onChange: (value: string) => void;
  type?: "text" | "email" | "password" | "number" | "search";
  placeholder?: string;
  disabled?: boolean;
  error?: string;
  required?: boolean;
}

export default function Input({
  id,
  name,
  value,
  onChange,
  type = "text",
  placeholder,
  disabled = false,
  error,
  required = false,
}: InputProps): React.JSX.Element {
  return (
    <div className="Input-Container">
      <input
        id={id}
        name={name}
        type={type}
        value={value}
        onChange={(e) => onChange(e.target.value)}
        placeholder={placeholder}
        disabled={disabled}
        required={required}
        className={`Input-Field ${error ? "Input-Error" : ""}`}
        aria-invalid={!!error}
      />
      {error && <span className="Input-ErrorMessage">{error}</span>}
    </div>
  );
}
