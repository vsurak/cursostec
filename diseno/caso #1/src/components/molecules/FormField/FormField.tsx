"use client";

import Label from "@components/atoms/Label/Label";
import Input from "@components/atoms/Input/Input";

interface FormFieldProps {
  id: string;
  name: string;
  label: string;
  value: string;
  onChange: (value: string) => void;
  type?: "text" | "email" | "password" | "number" | "search";
  placeholder?: string;
  error?: string;
  required?: boolean;
  disabled?: boolean;
}

export default function FormField({
  id,
  name,
  label,
  value,
  onChange,
  type = "text",
  placeholder,
  error,
  required = false,
  disabled = false,
}: FormFieldProps): React.JSX.Element {
  return (
    <div className="FormField-Container">
      <Label htmlFor={id} text={label} required={required} />
      <Input
        id={id}
        name={name}
        value={value}
        onChange={onChange}
        type={type}
        placeholder={placeholder}
        error={error}
        required={required}
        disabled={disabled}
      />
    </div>
  );
}
