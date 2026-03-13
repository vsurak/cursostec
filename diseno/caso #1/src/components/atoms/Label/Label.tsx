interface LabelProps {
  htmlFor: string;
  text: string;
  required?: boolean;
}

export default function Label({ htmlFor, text, required = false }: LabelProps): React.JSX.Element {
  return (
    <label className="Label-Root" htmlFor={htmlFor}>
      {text}
      {required && <span className="Label-Required">*</span>}
    </label>
  );
}
