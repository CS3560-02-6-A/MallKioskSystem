
import { theme } from "../../styles/theme";

export default function ChoiceCard({
  imageSrc,
  selectedImageSrc,
  alt,
  selected = false,
  style = {},
  imageStyle = {},
  ...props
}) {
  return (
    <button
      type="button"
      aria-pressed={selected}
      {...props}
      style={{
        border: "none",
        outline: "none",
        background: "transparent",
        boxShadow: "none",
        padding: 0,
        margin: 0,
        cursor: "pointer",
        ...style,
      }}
    >
      <img
        src={selected && selectedImageSrc ? selectedImageSrc : imageSrc}
        alt={alt}
        style={{
          width: "318px",
          maxWidth: "min(28vw, 424px)",
          maxHeight: "544px",
          height: "408px",
          objectFit: "contain",
          display: "block",
          ...imageStyle,
        }}
      />
    </button>
  );
}