import { Card } from 'react-bootstrap';
import ViewMoreButton from '../atoms/ViewMoreButton';
import '../../styles/molecules/ProductCard.css';

const ProductCard = ({ product }) => {
  return (
    <Card className="product-card">
      <div className="product-image-container">
        <Card.Img 
          variant="top" 
          src={product.image} 
          alt={product.name}
          loading="lazy"
        />
      </div>
      <Card.Body className="text-center">
        <Card.Title className="h4 mb-3">{product.name}</Card.Title>
        <Card.Text className="text-muted">{product.description}</Card.Text>
        <ViewMoreButton link={product.link} />
      </Card.Body>
    </Card>
  );
};

export default ProductCard;