# Projeto IMC - Clean Architecture

## 📖 O que aprendemos e implementamos

### 🔹 Estrutura do Projeto
- Organização em camadas seguindo o Clean Architecture:
  - Presentation/UI
  - Domain (UseCases)
  - Util (funções auxiliares)
- Criação do pacote `util` com centralização de validações.

### 🔹 Validações
  - Verificar campos vazios
  - Validar números positivos
- Decisão de validar tanto no Presentation (inputs do usuário) quanto no Domain (regras de negócio).

### 🔹 Testes
- `test` (unitários)