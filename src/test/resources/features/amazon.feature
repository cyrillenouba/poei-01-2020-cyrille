Feature: test amazon
Scenario: ajouter un article

  #connexion
  Given utilisateur est sur la  page Acceuil amazon
  When l utilsateur saisie l'article voulu et valide
  Then la liste des produits apparait
  #And : l'utilsateur clique sur l'article
  #And : l'utilisateur ajoute l'article au panier
  #And : l'utilisateur clique pour ajouter au panier pour le refus de la garantie
  #And : l'utilisateur clique sur le panier

  #ajout panier

