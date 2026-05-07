// ReceiptItem.jsx

// Receipt component: The individual item itself layout
// Displays Item image, name, location, price
export default function ReceiptItem({ item }) {
  return (
    <div className="receipt-item">

      <img src={item.imagePath || ""} alt={item.name} />

      <div className="receipt-item-info">
        <h3>{item.name}</h3>
        <button type="button">
          Store {item.storeId} - Aisle {item.aisle}
        </button>
      </div>

      <p className="receipt-price">
        ${Number(item.price || 0).toFixed(2)}
      </p>
    </div>
  );
}