// ReceiptCard.jsx

// Receipt component: The box to the left with the actual items details
// Displays Outfit Items text + items + Total Cost

import ReceiptItem from "./ReceiptItem";

export default function ReceiptCard({ items }) {
  const total = items.reduce((sum, item) => sum + item.price, 0);

  return (
    <div className="receipt-card">
      {/* TITLE */}
      <h2>Outfit Items</h2>

      <div className="receipt-line" />

      {/* OUTFIT LIST */}
      <div className="receipt-items">
        {items.map((item) => (
          <ReceiptItem key={item.id} item={item} />
        ))}
      </div>

      <div className="receipt-line" />

      {/* OUTFIT TOTAL */}
      <div className="receipt-total">
        <span>Estimated Total:</span>
        <strong>${total.toFixed(2)}</strong>
      </div>
    </div>
  );
}