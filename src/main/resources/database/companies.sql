-- Create the company_types table
CREATE TABLE company_types (
                               company_type_id INT AUTO_INCREMENT PRIMARY KEY,
                               type_name VARCHAR(100) NOT NULL UNIQUE,
                               description TEXT
);

-- Create the companies table
CREATE TABLE companies (
                           company_id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(255) NOT NULL,
                           contact_email VARCHAR(255) NOT NULL UNIQUE,
                           contact_phone VARCHAR(15),
                           address TEXT,
                           website VARCHAR(255),
                           company_type_id INT,
                           FOREIGN KEY (company_type_id) REFERENCES company_types(company_type_id)
);

-- Create the services table
CREATE TABLE services (
                          service_id INT AUTO_INCREMENT PRIMARY KEY,
                          service_name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price_range VARCHAR(100)
);

-- Create the company_services table (many-to-many relationship)
CREATE TABLE company_services (
                                  id INT AUTO_INCREMENT PRIMARY KEY,
                                  company_id INT,
                                  service_id INT,
                                  FOREIGN KEY (company_id) REFERENCES companies(company_id),
                                  FOREIGN KEY (service_id) REFERENCES services(service_id)
);

-- Create the reviews table
CREATE TABLE reviews (
                         review_id INT AUTO_INCREMENT PRIMARY KEY,
                         company_id INT,
                         reviewer_name VARCHAR(255) NOT NULL,
                         review_text TEXT,
                         rating INT CHECK (rating BETWEEN 1 AND 5),
                         review_date DATETIME DEFAULT CURRENT_TIMESTAMP,
                         FOREIGN KEY (company_id) REFERENCES companies(company_id)
);

-- Insert sample data into company_types
INSERT INTO company_types (type_name, description)
VALUES
    ('Catering', 'Provides food and beverage services'),
    ('Photography', 'Captures photos and videos'),
    ('Venue', 'Offers locations for wedding events'),
    ('Florist', 'Specializes in floral arrangements'),
    ('Event Planner', 'Coordinates all aspects of weddings');

-- Insert sample data into companies
INSERT INTO companies (name, contact_email, contact_phone, address, website, company_type_id)
VALUES
    ('Elegant Catering', 'info@elegantcatering.com', '123-456-7890', '123 Food St, Cityville', 'http://elegantcatering.com', 1),
    ('Wedding Lens Photography', 'contact@weddinglens.com', '234-567-8901', '456 Snap Ave, Pictown', 'http://weddinglens.com', 2),
    ('Dreamy Venues', 'sales@dreamyvenues.com', '345-678-9012', '789 Party Blvd, Eventopia', 'http://dreamyvenues.com', 3);

-- Insert sample data into services
INSERT INTO services (service_name, description, price_range)
VALUES
    ('Buffet Catering', 'A full buffet setup with various cuisines', '$500 - $5000'),
    ('Wedding Photography', 'Captures candid and posed wedding moments', '$1000 - $8000'),
    ('Outdoor Venue', 'A scenic outdoor space for weddings', '$3000 - $10000');

-- Link companies to services in company_services
INSERT INTO company_services (company_id, service_id)
VALUES
    (1, 1), -- Elegant Catering offers Buffet Catering
    (2, 2), -- Wedding Lens Photography offers Wedding Photography
    (3, 3); -- Dreamy Venues offers Outdoor Venue

-- Insert sample reviews
INSERT INTO reviews (company_id, reviewer_name, review_text, rating)
VALUES
    (1, 'John Doe', 'Excellent catering with a wide range of dishes!', 5),
    (2, 'Jane Smith', 'Captured our wedding moments beautifully!', 5),
    (3, 'Alice Brown', 'The venue was stunning and perfect for our theme.', 4);