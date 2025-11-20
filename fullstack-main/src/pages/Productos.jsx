import { useState } from 'react';
import { Container, Row, Col, Form } from 'react-bootstrap';
import ProductCard from '../components/molecules/ProductCard';
import '../styles/pages/Productos.css';
import { products as productos } from '../data/products.js';

function Productos() {
  const [maxPrice, setMaxPrice] = useState(1000);
  const handlePriceChange = (e) => {
    const value = e.target.value.replace(/\D/g, ''); // Solo permite números
    setMaxPrice(value === '' ? 0 : Number(value));
  };

  const filteredProducts = productos.filter(product => product.price <= maxPrice);

  return (
    <div className="products-page">
      <Container>
        <h1 className="text-center mb-5">Nuestros Productos</h1>
        <div className="price-filter-container mb-4">
          <h2 className="filter-title">Filtrar por precio</h2>
          <div className="price-input-container">
            <Form.Label>¿Cuál es tu presupuesto máximo?</Form.Label>
            <div className="input-group">
              <span className="input-group-text">$</span>
              <Form.Control
                type="text"
                value={maxPrice}
                onChange={handlePriceChange}
                placeholder="Ingresa tu presupuesto"
                className="price-input"
              />
            </div>
          </div>
        </div>
        <Row xs={1} md={2} lg={3} xl={4} className="g-4">
          {filteredProducts.length > 0 ? (
            filteredProducts.map(product => (
              <Col key={product.id}>
                <ProductCard product={product} />
              </Col>
            ))
          ) : (
            <Col xs={12}>
              <div className="no-products-message">
                No hay productos disponibles en este rango de precio
              </div>
            </Col>
          )}
        </Row>
      </Container>
    </div>
  );
}

export default Productos;