// ReceiptCard.jsx

// Receipt component: The box to the left with the actual items details
// Displays Outfit Items text + items + Total Cost
import ReceiptItem from "./ReceiptItem";

export default function ReceiptCard({ items = [] }) {
  const itemList = Array.isArray(items) ? items : Object.values(items);

  const total = itemList.reduce(
    (sum, item) => sum + Number(item.price || 0),
    0
  );

  return (
    <div className="receipt-card">
      <h2>Outfit Items</h2>

      <div className="receipt-line" />

      <div className="receipt-items">
        {itemList.map((item) => (
          <ReceiptItem
            key={`${item.itemId}-${item.storeId}`}
            item={item}
          />
        ))}
      </div>

      <div className="receipt-line" />

      <div className="receipt-total">
        <span>Estimated Total:</span>
        <strong>${total.toFixed(2)}</strong>
      </div>
    </div>
  );
}